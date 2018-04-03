
public class Ex1 {
    public static void main(String[] args) {
//        String[] origItems = new String[] {"rice", "sugar", "wheat", "cheese"};
//        float[] origPrices = new float[] {16.89f, 56.92f, 20.89f, 345,99f};
//        String[] items = new String[] {"rice", "cheese"};
//        float[] prices = new float[] {18.99f, 400.89f};
        
        String[] origItems = new String[] {"chocolate", "cheese", "tomato"};
        float[] origPrices = new float[] {15.00f, 300.90f, 23.44f};
        String[] items = new String[] {"cheese", "tomato", "chocolate"};
        float[] prices = new float[] {300.90f, 23.44f, 10.00f};
        System.out.println(verifyItems(origItems, origPrices, items, prices));
        
    }
    
    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        java.util.Map<String, Float> origs = new java.util.HashMap<>();
        java.util.Map<String, Float> records = new java.util.HashMap<>();
        // map all origItems and origPrices
        // map all items and prices
        for(int i=0; i<origItems.length; i++) {
            origs.put(origItems[i], origPrices[i]);
            if(i<items.length) {
                records.put(items[i], prices[i]);
            }
        }
        // compare recordKey from records to origs.
        int incorrectRecords = 0;
        for(String recordKey: records.keySet()) {
            if(Float.compare(origs.get(recordKey), records.get(recordKey)) != 0) {
                incorrectRecords++;
            }
        }
        
        return incorrectRecords;
    }
}
