
/**
 * Write a description of class Enigma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enigma
{
    public String process;
    char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                        'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public Enigma(){
        
    }
    
    public String encrypt(String str){
        int spaceCount = 0;
        for(int i=0;i<str.length();i++)
        {
           char ch=str.charAt(i);
           if(ch==' '){
            spaceCount++;
           }
        }
        int[] spaces = new int[spaceCount];
        int counter=0;
        for(int i=0;i<str.length();i++)
        {
           char ch=str.charAt(i);
           if(ch==' '){
              spaces[counter] = i;
              counter++;
           }
        }
        counter = 0;
        StringBuilder str1 = new StringBuilder();
        str = str.replaceAll("\\s","");
        for (int x=0;x<str.length();x++){
            for (int i=0;i<26;i++){
                 if (Character.toUpperCase(str.charAt(x)) == alphabet[i]){
                    str1.insert(x,alphabet[25-i]); 
                 }
            }
        }
        
        for(int x=str1.length();counter<spaceCount;x=str1.length()){
           str1.insert(x,'ᚾ');
           str1.insert(x+1,spaces[counter]);
           counter++;
           /*int y = spaces[counter];
           str1.insert(x,alphabetlow[y]);
           counter++;
           if(counter>26){
            counter=counter-26;
            }*/
        }
        counter=0;
        str1.insert(str1.length(),'ᚾ');
        return str1.toString();
    }

    
    public String decrypt(String str){
        int spaceCount = 0;
        for(int i=0;i<str.length();i++)
        {
           char ch=str.charAt(i);
           if(ch=='ᚾ'){
            spaceCount++;
           }
        }
        int[] spaces = new int[spaceCount];
        int counter=0;
        for(int i=0;i<str.length()-1;i++)
        {
           char ch=str.charAt(i);
           if(ch=='ᚾ'){
              //spaces[counter] = str.charAt(i+1);
              String temp = str.substring(i+1,str.indexOf('ᚾ',i+1));
              spaces[counter] = Integer.parseInt(temp);
              counter++;
           }
        }
        counter = 0;
        StringBuilder str1 = new StringBuilder();
        for (int x=0;x<str.length();x++){
            for (int i=0;i<26;i++){
                 if (Character.toUpperCase(str.charAt(x)) == alphabet[i]){
                    str1.insert(x,alphabet[25-i]);
                 }
            }
        }
        for (int i=0;i<spaceCount;i++){
           //str1.insert(Character.getNumericValue(spaces[i])," ");
           str1.insert(spaces[i]," ");
        }
        return str1.toString();
    }
}
