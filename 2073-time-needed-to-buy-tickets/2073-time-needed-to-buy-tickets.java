class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int targetTickets = tickets[k];
        
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // Pehle wale aur k khud: max 'targetTickets' tak khareed sakte hain
                time += Math.min(tickets[i], targetTickets);
            } else {
                // Baad wale: max 'targetTickets - 1' tak khareed sakte hain
                time += Math.min(tickets[i], targetTickets - 1);
            }
        }
        
        return time;
    }
}