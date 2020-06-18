import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if (n == 0) return list;

        dfs(0,0,n,list, "");
        return list;
    }

    public void dfs(int close, int open, int depth, List<String> res, String str) {
        if (str.length() == depth * 2) {
            res.add(str);
            return;
        }

        if (open < depth) {
            dfs(close, open + 1, depth, res , str + "(");
        }

        if (close < open) {
            dfs(close + 1, open, depth, res, str + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses ge = new GenerateParentheses();
        List<String> res = ge.generateParenthesis(3);

        for (String str : res) {
            System.out.println(str);
        }
    }
}
