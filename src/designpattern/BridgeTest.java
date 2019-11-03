package designpattern;

public class BridgeTest {

    public interface Color {
        void paint(String str, int penType);
    }

    public class Red implements Color {
        @Override
        public void paint(String str, int penType) {
            System.out.println("Red color : " + str + "\npenType = " + penType);
        }
    }

    public class Blue implements Color {
        @Override
        public void paint(String str, int penType) {
            System.out.println("Blue color : " + str + "\npenType = " + penType);
        }
    }

    public abstract class Pen {
        protected Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public abstract void draw(String name);
    }

    public class BigPen extends Pen {
        @Override
        public void draw(String name) {
            color.paint(name, 2);
        }
    }

    public class SmallPen extends Pen {
        @Override
        public void draw(String name) {
            color.paint(name, 1);
        }
    }
}
