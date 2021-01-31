package cn.clown.dynamicproxy;

/**
 * 静态代理举例
 * @author clown
 */
interface ClothFactory{
    /**
     * 生产衣服
     */
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{
    private  ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}
/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产一批运动服");
    }
}

/**
 * @author Administrator
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nick = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nick);

    }
}
