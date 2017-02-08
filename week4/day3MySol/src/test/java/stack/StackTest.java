package stack;
import org.junit.Before;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
public class StackTest {
    private Stack <String> stackString = new Stack<>();
    private Stack <Number> stackNumber = new Stack<>();
    
    @Before
    public void stackIsEmpty() {
        assertThat(stackString.isEmpty()).isTrue();
        assertThat(stackNumber.isEmpty()).isTrue();
    }
    
    @Test
    public void stackPush() {
        stackString.push("H");
        stackNumber.push(2);
        stackString.push("A");
        stackNumber.push(22);
        assertSize(2);
    }
    
    @Test
    public void stackEmptyPop() {
        assertThat(stackString.pop()).isNull();
    }
    
    @Test
    public void stackPop() {
        stackString.push("H");
        stackNumber.push(2);
        assertSize(1);
        assertThat(stackString.pop()).isEqualTo("H");
        assertThat(stackNumber.pop()).isEqualTo(2);
        assertSize(0);
    }
    
    @Test
    public void peek() {
//      stackString.push("H");
//      stackNumber.push(2);
//      assertSize(1);
//      assertThat(stackString.pop()).isEqualTo("H");
//      assertThat(stackNumber.pop()).isEqualTo(2);
//      assertSize(0);
    }
    
    private void assertSize(int size) {
        assertThat(stackString.size()).isEqualTo(size);
        assertThat(stackNumber.size()).isEqualTo(size);
    }
}
