public class Pizza {
    String name;
    String details;
    int S_price;
    int M_price;
    int L_price;
    Pizza left,right;
    public Pizza(String name, String details, int s_price, int m_price, int l_price) {
        this.name = name;
        this.details = details;
        S_price = s_price;
        M_price = m_price;
        L_price = l_price;
        this.left = null;
        this.right = null;
    }


}


//
