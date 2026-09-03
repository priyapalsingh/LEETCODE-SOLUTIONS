class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int x : nums1) {
            if (x < minVal) {
                minVal = x;
            }
            if (x % 2 != 0) {
                hasOdd = true;
            }
        }

        // Agar sabse chhota element odd hai, ya array mein koi odd hai hi nahi
        if (minVal % 2 != 0 || !hasOdd) {
            return true;
        }

        return false;
    }
} /*
Agar sabse chhota element ODD hai:Answer hamesha true hoga!Har odd number ko waise hi chhod do.Har even number $x$ mein se is sabse chhote odd number ko subtract kar do:$$\text{even} - \text{odd} = \text{odd}$$Kyunki ye overall sabse chhota element hai, toh har even number ke liye $x - \text{minOdd} \ge 1$ hamesha valid rahega.Agar sabse chhota element EVEN hai:Is sabse chhote even element se chhota koi number exist hi nahi karta, toh isme se kuch subtract karke isko odd nahi banaya ja sakta.Iska matlab hume sabhi numbers ko EVEN hi banana padega.Kisi odd number ko even banane ke liye:$$\text{odd} - \text{odd} = \text{even}$$Hume us odd number se chhota ek aur odd number subtract karna padega.Lekin agar array mein koi bhi odd number exist karta hai, toh jo sabse chhota odd number hoga, usse chhota koi aur odd nahi hoga jise minus kiya ja sake!Isliye: agar minVal even hai, toh answer sirf tabhi true ho sakta hai jab pure array mein koi odd number ho hi na (yaani saare elements already even hon).*/