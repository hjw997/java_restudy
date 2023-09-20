package DesignPattern.rxjavastudy.a_core;

/**
 * 事件发射器
 * 在标准的观察者模式中,被观察者 数据更新后会去调用 notifyObservers ,类似:
 * void notifyObservers() {
 *     for(Observer observer : observers) {
 *         //被观察者告诉 观察者 我变了.
 *         observer.update() //这里update()为何没传参数,是因为可以
 *     }
 * }
 * 在RxJava中的 这种作了变种,通过一个发射器 将数据变更后 发射出去.
 * 事件发射器的 方法其实就 和 Observer 的一样.  标准观察者 通知观察者更新:update()方法.
 * 被观察者和事件发射器是需要关联的. 也就是 被观察者 持有一个发射器, 有变化发射出去.
 * 被观察者 和 发射器 是建立关系 通过接口 ObservableOnSubscribe接口
 */
public interface Emitter<T> {

    void onNext(T t);  //为何叫onNext 因为.像流一下 一步一步往下

    void onComplete();

    void  onError(Throwable throwable);

}
