package io.training;


public class Prison {

    Bar[] hBars;
    Bar[] vBars;


    public Prison(Bar[] vBars, Bar[] hBars) {
        this.hBars = hBars;
        this.vBars = vBars;
    }

    public static Prison unit(int vsize, int hsize) {
        Bar[] vBars = new Bar[vsize + 1];
        for (int i = 0; i < vBars.length; i++) {
            vBars[i] = Bar.unit();
        }

        Bar[] hBars = new Bar[hsize + 1];
        for (int i = 0; i < hBars.length; i++) {
            hBars[i] = Bar.unit();
        }
        return new Prison(vBars, hBars);
    }

    Prison removeVBars(int... vbars) {
        Prison p = this;
        for (int i = 0; i < vbars.length; i++) {
            p = new Prison(newBars(vbars[i], p.vBars), p.hBars);
        }
        return p;
    }

    Prison removeHBars(int... hbars) {
        Prison p = this;
        for (int i = 0; i < hbars.length; i++) {
            p = new Prison(p.vBars, newBars(hbars[i], p.hBars));
        }
        return p;
    }

    int maxArea() {
        int maxArea = 1;
        for (int i = 0; i < vBars.length; i++) {
            for (int j = 0; j < hBars.length; j++) {
                maxArea = Math.max(maxArea, vBars[i].size * hBars[j].size);
            }
        }
        return maxArea;
    }

    private Bar[] newBars(int b, Bar[] bars) {
        Bar[] newVBars = new Bar[bars.length - 1];
        for (int i = 0; i < newVBars.length; i++) {
            if (b - 1 == i) {
                newVBars[i] = new Bar(bars[b - 1].size + bars[b].size);
            } else {
                newVBars[i] = bars[i];
            }
        }
        return newVBars;
    }
}