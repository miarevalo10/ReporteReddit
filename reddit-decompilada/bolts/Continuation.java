package bolts;

public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult mo769a(Task<TTaskResult> task) throws Exception;
}
