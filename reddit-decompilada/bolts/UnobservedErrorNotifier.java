package bolts;

class UnobservedErrorNotifier {
    Task<?> f2731a;

    public UnobservedErrorNotifier(Task<?> task) {
        this.f2731a = task;
    }

    protected void finalize() throws Throwable {
        try {
            Task task = this.f2731a;
            if (!(task == null || Task.m2405a() == null)) {
                UnobservedTaskException unobservedTaskException = new UnobservedTaskException(task.m2421f());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
