package DesignPattern.p_observer.e;

/**
 * 老师说:来自 Header First 设计模式的案例
 * 高喷(设计模式)最后一节课:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 气象站:
 */
class WeatherStation {
    //湿度
    private Integer temperature;
    //温度
    private Integer humidity;

    //气压
    private Integer pressure;

    //观察者们 的集合
    private List<Observer> observers = new ArrayList<>();

    ///假设来自温度传感器的数据:
    public void setData(Integer temperature, Integer humidity, Integer pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        /// 因为气象站是个被观察者 所有数据更新的时候要通知观察者们.
        notifyObservers();
    }

    /**
     * 数据变动通知观察者们 :
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            //通知观察者:  我更新了哈~
            observer.update();
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }
}

/**
 * 观察者接口:
 */
interface Observer {
    void update(); //这里不给update传参,上层调用不依赖任何底层实现类.完全解耦.
    /**
     * 思路就是: 观察者自己在创建的时候 自己引用一个 被观察者.
     */
}

/// 手机观察者
class Phone implements Observer{
    //直接持有 被观察的对象
    private WeatherStation ws;

    public Phone(WeatherStation ws) {
        this.ws = ws;
         ///被观察者 直接这里 addObserver
    }

    @Override
    public void update() {
        /**
         * 被观察者通知观察者以后 观察者自己去 拉数据 pull
         */
        System.out.println("------手机界面-----");
        System.out.println("当前数据:");
        System.out.println("温度:" + ws.getTemperature());
        System.out.println("湿度:" + ws.getHumidity());
        System.out.println("气压:" + ws.getPressure());

    }
}

/// 智能家具的窗户上也显示气象信息
class Window implements Observer {
    //直接持有 被观察的对象
    private WeatherStation ws;

    public Window(WeatherStation ws) {
        this.ws = ws;
        ///被观察者 直接这里 addObserver 省去在外面添加.
        // 可以把添加观察者写到这里,但是要注意 添加重复了等问题.
        // ws.addObserver(this);
    }
    @Override
    public void update() {
        /**
         * 被观察者通知观察者以后 观察者自己去 拉数据 pull
         */
        System.out.println("------窗户显示-----");
        System.out.println("当前数据:");
        System.out.println("温度:" + ws.getTemperature());
        System.out.println("湿度:" + ws.getHumidity());
        System.out.println("气压:" + ws.getPressure());

    }
}

//========================时空线=============

/**
 * 广告牌:也要显示数据,用户自己扩展的
 */
class AdvertisementBoard implements Observer {
    //直接持有 被观察的对象
    private WeatherStation ws;

    public AdvertisementBoard(WeatherStation ws) {
        this.ws = ws;
        ///被观察者 直接这里 addObserver 省去在外面添加.
        // 可以把添加观察者写到这里,但是要注意 添加重复了等问题.
        // ws.addObserver(this);
    }
    @Override
    public void update() {
        /**
         * PS学习中这里是打印 实际业务中网络编程,微服务等
         */
        System.out.println("------窗户显示-----");
        System.out.println("当前数据:");
        System.out.println("温度:" + ws.getTemperature());
        System.out.println("湿度:" + ws.getHumidity());
        System.out.println("气压:" + ws.getPressure());

    }
}

public class AppTest {
    public static void main(String[] args) {
        //创建被观察者
        WeatherStation weatherStation = new WeatherStation();

        //创建观察者
        Observer phone = new Phone(weatherStation);
        Observer window = new Window(weatherStation);

        //被观察者收集 观察者
        weatherStation.addObserver(phone);
        weatherStation.addObserver(window);

        //气象站温度更新:
        weatherStation.setData(29,8,40);
    }
}

/**
 * 上面的代码还可以改进:把主体(Subject)中很多重复的代码抽象 请看f包;
 */