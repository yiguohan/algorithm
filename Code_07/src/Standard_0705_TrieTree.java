/**
 * 前缀树
 */
public class Standard_0705_TrieTree {
    public static class Node {
        public int pass;//到达节点多少次
        public int end;//有多少个字符串是以这个节点结尾的
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            //next[0]==null 说明没有走向'a'的路
            //next[0]!=null 说明有走向'a'的路
            nexts = new Node[26];
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            root.pass++;
            char[] chs = word.toCharArray();
            Node cur = root;
            int index = 0;//哪条路
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] = 'a';//index 范围0~25
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new Node();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                root.pass--;
                char[] chs = word.toCharArray();
                Node node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * 查询word被加入过几次
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 查询有多少个加入过的字符以pre开头
         *
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
