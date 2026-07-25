class Solution {
    public String defangIPaddr(String address) {
        String new1 =address.replace(".","[.]");
        return new1;
    }
}