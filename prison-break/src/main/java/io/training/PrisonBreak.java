package io.training;

import java.util.stream.IntStream;

public class PrisonBreak {
    Prison prison;

    public PrisonBreak(Prison prison) {
        this.prison = prison;
    }

    public int escape(int[] hBars, int[] vBars) {
        return prison.removeHBars(normalize(hBars))
                .removeVBars(normalize(vBars))
                .maxArea();
    }

    private int[] normalize(int[] bars) {
        return IntStream.range(0, bars.length).map(i -> bars[i] - i).sorted().toArray();
    }
}
