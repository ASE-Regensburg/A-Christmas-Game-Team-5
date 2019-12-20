package snowballs;

public enum SnowballSpeed implements SnowballPixelSpeed {
    SLOW,
    MEDIUM,
    FAST;

    public static int getSpeed(SnowballSpeed speed) {
        switch (speed) {
            case SLOW:
                return SLOW_SPEED;
            case MEDIUM:
                return MEDIUM_SPEED;
            case FAST:
                return FAST_SPEED;
            default:
                return STOP;
        }
    }
}
