package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //static 으로 되어 있으면 하나로 만들어져서 올라간다
    
    //내부적으로 자기자신을 생성하고 instance에 참조에 넣고 여기 안에만 들어가 있는 것이다

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
        // 이렇게 하면 new 로 만들지 못함
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");

    }
    
    
}
