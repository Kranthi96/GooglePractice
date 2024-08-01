/*pass array of string reprsent emails
email => local@domain. => lowercase
domain =>ends with .com
local => . or + (multiple combinations)
. => don't consider
+ => after + we won't consider till end of local
local=> don't start with +

*/


class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails.length <= 1) return emails.length;
        Set<String> emailSet = new HashSet<>();
        for(int i=0; i<emails.length; i++){
            emailSet.add(processEmail(emails[i]));
        }
        return emailSet.size();
        
        
    }
    public String processEmail(String email){
        StringBuilder result = new StringBuilder();
        for(int i=0; i< email.length(); i++){
            char curr = email.charAt(i);
            if(curr == '.') continue;
            else if(curr =='+') while(email.charAt(i+1) != '@') i++;
            else if(curr == '@') 
                while(i<email.length()){
                    curr = email.charAt(i);
                    result.append(curr);
                    i++;
                }
            else
                result.append(curr);
            
        }
        return result.toString();
        
    }
}
