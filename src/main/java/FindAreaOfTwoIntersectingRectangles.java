
public class FindAreaOfTwoIntersectingRectangles {
    
    public static class Rectangle{
        public int x;// left
        public int y;// bottom
        public int w;// width
        public int h;// height
        
        
        
        public Rectangle(int x, int y, int w, int h) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public static boolean isIntersecting(Rectangle r1, Rectangle r2) {
            if((r1.x <= (r2.x + r2.w)) 
                    && (r2.x <= (r1.x + r1.w))
                    && (r1.y <= (r2.y + r2.h)) 
                    && (r2.y <= (r1.y + r1.h))
                    ) return true;
            return false;
        }
        
        public static int getAreaOfTwoIntersectingRectangles(Rectangle r1, Rectangle r2) {
            if(isIntersecting(r1, r2)) {
                int w = Math.min((r1.x + r1.w - r2.x), (r2.x + r2.w - r1.x));
                int h = Math.min((r1.y + r1.h - r2.y), (r2.y + r2.h - r1.y));
                return w * h;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1, 2, 2, 2);
        Rectangle r2 = new Rectangle(1, 2, 2, 2);
        System.out.println(Rectangle.getAreaOfTwoIntersectingRectangles(r1, r2));
    }

}
