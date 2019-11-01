import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class Test {
    public final int A;
    {
        A = 10;
    }

    public final void TestFinialVoid(){
        Reference.reachabilityFence(this);

        Reference.reachabilityFence(this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
