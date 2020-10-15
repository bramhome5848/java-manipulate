package kr.com.lkj.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {
        //practice1();
        practice2();
    }

    public static void practice1() {
        //클래스 재정의 -> Byte Buddy 를 통한 bytecode 조작
        //컴파일 하듯이 try - catch 문 실행하여 바이트 코드 변경
        //이후 다시 실행하여 변경된 결과 확인
        try {
            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
                    .make().saveIn( new File("/Users/LeeKyungJin/Desktop/java-manipulate/target/classes/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //처음 같이 수행할 경우 new 에서 조작되지 않은 원래의 클래스 정보를 메모리에서 이용하기 떄문에
        //Rabbit!! 이 출력되지 않음
        System.out.println(new Moja().pullOut());

        /**
         * 정리
         * 위의 코드를 동시에 사용할 수 없는 이유 -> Masulsa 를 실행하면 Masulsa.class, Moja.class로 컴파일 되고
         * 그 클래스 파일들이 로딩되고 실행되기 때문에, 그 이후에 바이트 버디를 통해서 class 파일을 조작해도
         * 이미 로딩된 클래스 정보를 사용하기 때문에 적용이 되지 않음 -> 그래서 처음 같이 실행시 ""이 출력됨
         */
    }

    /**
     * 클래스로더가 클래스를 읽어올 때 javaagent 를 거쳐서 변경된 바이트코드를 읽어들여 사용
     * MasulsaAgent 확인
     * clean package 수행후 VM 옵션 ->
     * -javaagent:/Users/LeeKyungJin/Desktop/java-manipulate/target/java-manipulate-1.0-SNAPSHOT.jar
     * 존재하는 class 파일은 변경되지 않음 -> javaagent가 수행하는 일이 클래스 로딩할 때 적용되기 때문에
     * 클래스로더가 클래스를 읽어올 때 javaagent를 거쳐서 변경된 바이트코드를 읽어들여 사용
     */
    public static void practice2() {
        System.out.println(new Moja().pullOut());
    }
}
