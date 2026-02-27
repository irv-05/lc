class Logger {
    protected class TimeBucket {
        private Set<String> messages;
        private final int timestamp;

        public TimeBucket(int timestamp) {
            messages = new HashSet<>();
            this.timestamp = timestamp;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public Set<String> getMessages() {
            return messages;
        } 

        public void addMessage(String message) {
            messages.add(message);
        }
    }

    private Set<String> messageCache;
    private Deque<TimeBucket> buckets;

    public Logger() {
        messageCache = new HashSet<>();
        buckets = new ArrayDeque<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        cleanOldMessages(timestamp);

        if(!messageCache.contains(message)) {
            TimeBucket last = buckets.peekLast();
            if(!buckets.isEmpty() && last.getTimestamp() == timestamp) {
                last.addMessage(message);
            } else {
                TimeBucket cur = new TimeBucket(timestamp);
                cur.addMessage(message);
                buckets.addLast(cur);
            }

            messageCache.add(message);

            return true;
        }

        return false;
    }

    private void cleanOldMessages(final int timestamp) {
        while(!buckets.isEmpty() && timestamp - buckets.peekFirst().getTimestamp() >= 10) {
            TimeBucket cur = buckets.pop();
            for(String message : cur.getMessages()) {
                messageCache.remove(message);
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */