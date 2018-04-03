package preparation.chapter5;

public class Ex11 {
    public static class Rectangle{
        public Rectangle(int l, int b, int w, int h){
            this.l = l;
            this.b = b;
            this.w = w;
            this.h = h;
        }
        int l;
        int b;
        int w;
        int h;

        @Override
        public String toString() {
            return "Rectangle{" +
                    "l=" + l +
                    ", b=" + b +
                    ", w=" + w +
                    ", h=" + h +
                    '}';
        }

        public static boolean isIntersection(Rectangle r1, Rectangle r2){
            return (r1.l <= r2.l + r2.w
                    && r2.l <= r1.l + r1.w
                    && r1.b <= r2.b + r2.h
                    && r2.b <= r1.b +r1.h) ;
        }

        public static Rectangle intersectedRectangle(Rectangle r1, Rectangle r2){
            if (!isIntersection(r1, r2)) return new Rectangle(-1, -1, 0, 0);
            return new Rectangle(Math.max(r1.l, r2.l)
            , Math.max(r1.b, r2.b)
            , Math.min(r1.l + r1.w, r2.l + r2.w) - Math.max(r1.l, r2.l)
            , Math.min(r1.b + r1.h, r2.b + r2.h) - Math.max(r1.b, r2.b));
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0, 0, 3, 2);
        Rectangle r2 = new Rectangle(0, 1, 3, 2);
        Rectangle r3 = Rectangle.intersectedRectangle(r1, r2);
        System.out.println(r3);
    }

}
