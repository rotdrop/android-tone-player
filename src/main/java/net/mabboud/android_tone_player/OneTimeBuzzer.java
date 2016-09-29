package net.mabboud.android_tone_player;

/**
 * A buzzer that will end after the set duration has ended or stop() is called.
 * Default duration is 5 seconds.
 */
public class OneTimeBuzzer extends TonePlayer {
    protected double duration = 5;

    public OneTimeBuzzer(double duration) {
        this.duration = duration;
    }

    OneTimeBuzzer() {
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    protected void asyncPlayTrack(final double toneFreqInHz) {
        playerWorker = new Thread(new Runnable() {
            public void run() {
                playTone(toneFreqInHz, duration);
            }
        });

        playerWorker.start();
    }
}
