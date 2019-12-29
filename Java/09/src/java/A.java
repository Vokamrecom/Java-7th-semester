package Lab6;

public class A {
    private int A;
    private int B;
    private int C;

    public A() {
        SetA(0);
        SetB(0);
        SetC(0);
    }

    public void SetA(int value) {
        A = value;
    }

    public int GetA() {
        return A;
    }

    public void SetB(int value) {
        B = value;
    }

    public int GetB() {
        return B;
    }

    public void SetC(int value) {
        C = value;
    }

    public int GetC() {
        return C;
    }
}