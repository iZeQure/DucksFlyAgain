package com.example.ducksflyagain;

public class MainActivityPresenter implements Quackable {
    private Duck duck = new Duck();
    private View v;

    MainActivityPresenter(View v) {
        this.v = v;
    }

    public void allowQuacking() {
        duck.addListener(this);
        duck.beginQuack();
    }

    @Override
    public void quack(boolean isQuacking) {
        this.v.quacking(isQuacking);
    }

    public interface View {
        void quacking(boolean silent);
    }
}
