package taskTwo;

public class FizzBuzz {
    private int n;
    private volatile int current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
    }

    public void fizz() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current % 3 != 0 || current % 5 == 0) {
                    if (current > n) {
                        return;
                    }
                    wait();
                }
                System.out.println("fizz");
                current++;
                notifyAll();
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current % 5 != 0 || current % 3 == 0) {
                    if (current > n) {
                        return;
                    }
                    wait();
                }
                System.out.println("buzz");
                current++;
                notifyAll();
            }
        }
    }

    public void fizzBuzz() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current % 3 != 0 || current % 5 != 0) {
                    if (current > n) {
                        return;
                    }
                    wait();
                }
                System.out.println("fizzbuzz");
                current++;
                notifyAll();
            }
        }
    }

    public void number() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (current % 3 == 0 || current % 5 == 0) {
                    if (current > n) {
                        return;
                    }
                    wait();
                }
                System.out.println(current);
                current++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;

        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzBuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}