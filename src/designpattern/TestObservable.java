package designpattern;

import java.util.ArrayList;
import java.util.List;

public class TestObservable {

    /**
     * 抽象被观察者
     **/
    interface Observable {
        //注册观察者
        void registerObserver(Observer observer);

        //解除绑定观察者
        void unRegisterObserver(Observer observer);

        //更新数据
        void notifyObservers();
    }

    /**
     * 抽象观察者
     */
    interface Observer {
        void update(Observable observable, Object value);
    }

    /**
     * 具体被观察者
     **/
    public class MyView implements Observable {
        List<Observer> observerList;
        private int progress;

        public MyView() {
            this.observerList = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            if (observerList.contains(observer)) {
                return;
            }
            observerList.add(observer);
        }

        @Override
        public void unRegisterObserver(Observer observer) {
            int i = observerList.indexOf(observer);
            if (i >= 0) {
                observerList.remove(observer);
            }
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observerList) {
                observer.update(this, progress);
            }
        }

        public void setProgress(int progress) {
            this.progress = progress;
            notifyObservers();
        }
    }

    /**
     * 具体观察者
     */
    public class ProgressListener implements Observer {
        @Override
        public void update(Observable observable, Object value) {
            System.out.println("progress = " + value);
        }
    }

    public void main(String[] args) {
        MyView myView = new MyView();
        Observer progressListener = new ProgressListener();
        myView.registerObserver(progressListener);
        myView.setProgress(10);
    }

}
