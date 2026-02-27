class Logger {
    private Map<String, Integer> messageCache;
    public Logger() {
        messageCache = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrint = false;
        if(!messageCache.containsKey(message)) {
            shouldPrint = true;
        } else if(timestamp - messageCache.get(message) >= 10) {
            shouldPrint = true;
        }

        if(shouldPrint) {
            messageCache.put(message, timestamp);
        }
        
        return shouldPrint;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */