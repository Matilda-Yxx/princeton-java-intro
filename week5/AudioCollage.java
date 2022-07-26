package week5;
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        for (int i = 0; i < a.length; i++) a[i] *= alpha;
        return a;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[a.length-1-i];
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0 ;i < a.length; i++) c[i] = a[i];
        for (int i = 0; i < b.length; i++) c[i + a.length] = b[i];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if(a.length > b.length) { // b is shorter, should be padded
            double[] c = new double[a.length];
            for (int i = 0; i < b.length; i++) c[i] = b[i];
            b = c;
        } else { // a is shorter, should be padded
            double[] c = new double[b.length];
            for(int i = 0; i < a.length; i++) c[i] = a[i];
            a = c;
        }

        // now a and b are of the same length
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) c[i] = a[i] + b[i];
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        int newLen = (int) Math.floor(n/alpha);
        double[] resampledSeq = new double[newLen];
        for (int i = 0; i < newLen; i++) {
            resampledSeq[i] = a[(int) Math.floor(i*alpha)];
        }
        return resampledSeq;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args){

        double[] a = StdAudio.read("cow.wav");
        double[] b = StdAudio.read("piano.wav");
        double[] c = StdAudio.read("beatbox.wav");
        double[] d = StdAudio.read("harp.wav");
        double[] e = StdAudio.read("chimes.wav");
        a = amplify(a, 2);
        b = changeSpeed(b, 1.5);
        c = reverse(c);
        a = merge(a, b);
        c = mix(c, d);
        a = merge(a, c);
        a = mix(a, e);

        // check duration
        while(a.length < 441000) {
            a = merge(a, a);
        }

        if(a.length > 2646000) {
            double[] temp = new double[2646000];
            for (int i = 0 ; i < 2646000 ; i++) temp[i] = a[i];
            a = temp;
        }

        // rescaling the output to -1 ~ 1
        double max = -1.0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > max) max = Math.abs(a[i]);
        }
        a = amplify(a, 1/max);
 
        // PLAY!
        StdAudio.play(a);
    }
}