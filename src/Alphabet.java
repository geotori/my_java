public class Alphabet {
    char c = 'A';
    public char increment() {
        if (c == 'Z')
            c = 'a';
        else if (c == 'z')
            c = 'A';
        else
            c++;
        return c;
    }
    public void set(char in_c) {
        c = in_c; // no check, not asked for
    }
}