package org.dsa.examples.lc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder-ii/submissions/1616031465/
public class _126WordLadder21 {

  public static void main(String[] args) {
    String beginWord = "red"; // hit // aaaaa
    String endWord = "tax"; // cog // ggggg
    List<String> wordDict =
        List.of("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
    // List.of("hot", "dot", "dog", "lot", "log", "cog");
    //  List.of("aaaaa", "caaaa", "cbaaa", "daaaa", "dbaaa", "eaaaa", "ebaaa", "faaaa", "fbaaa", "gaaaa", "gbaaa", "haaaa", "hbaaa", "iaaaa", "ibaaa", "jaaaa", "jbaaa", "kaaaa", "kbaaa", "laaaa", "lbaaa", "maaaa", "mbaaa", "naaaa", "nbaaa", "oaaaa", "obaaa", "paaaa", "pbaaa", "bbaaa", "bbcaa", "bbcba", "bbdaa", "bbdba", "bbeaa", "bbeba", "bbfaa", "bbfba", "bbgaa", "bbgba", "bbhaa", "bbhba", "bbiaa", "bbiba", "bbjaa", "bbjba", "bbkaa", "bbkba", "bblaa", "bblba", "bbmaa", "bbmba", "bbnaa", "bbnba", "bboaa", "bboba", "bbpaa", "bbpba", "bbbba", "abbba", "acbba", "dbbba", "dcbba", "ebbba", "ecbba", "fbbba", "fcbba", "gbbba", "gcbba", "hbbba", "hcbba", "ibbba", "icbba", "jbbba", "jcbba", "kbbba", "kcbba", "lbbba", "lcbba", "mbbba", "mcbba", "nbbba", "ncbba", "obbba", "ocbba", "pbbba", "pcbba", "ccbba", "ccaba", "ccaca", "ccdba", "ccdca", "cceba", "cceca", "ccfba", "ccfca", "ccgba", "ccgca", "cchba", "cchca", "cciba", "ccica", "ccjba", "ccjca", "cckba", "cckca", "cclba", "cclca", "ccmba", "ccmca", "ccnba", "ccnca", "ccoba", "ccoca", "ccpba", "ccpca", "cccca", "accca", "adcca", "bccca", "bdcca", "eccca", "edcca", "fccca", "fdcca", "gccca", "gdcca", "hccca", "hdcca", "iccca", "idcca", "jccca", "jdcca", "kccca", "kdcca", "lccca", "ldcca", "mccca", "mdcca", "nccca", "ndcca", "occca", "odcca", "pccca", "pdcca", "ddcca", "ddaca", "ddada", "ddbca", "ddbda", "ddeca", "ddeda", "ddfca", "ddfda", "ddgca", "ddgda", "ddhca", "ddhda", "ddica", "ddida", "ddjca", "ddjda", "ddkca", "ddkda", "ddlca", "ddlda", "ddmca", "ddmda", "ddnca", "ddnda", "ddoca", "ddoda", "ddpca", "ddpda", "dddda", "addda", "aedda", "bddda", "bedda", "cddda", "cedda", "fddda", "fedda", "gddda", "gedda", "hddda", "hedda", "iddda", "iedda", "jddda", "jedda", "kddda", "kedda", "lddda", "ledda", "mddda", "medda", "nddda", "nedda", "oddda", "oedda", "pddda", "pedda", "eedda", "eeada", "eeaea", "eebda", "eebea", "eecda", "eecea", "eefda", "eefea", "eegda", "eegea", "eehda", "eehea", "eeida", "eeiea", "eejda", "eejea", "eekda", "eekea", "eelda", "eelea", "eemda", "eemea", "eenda", "eenea", "eeoda", "eeoea", "eepda", "eepea", "eeeea", "ggggg", "agggg", "ahggg", "bgggg", "bhggg", "cgggg", "chggg", "dgggg", "dhggg", "egggg", "ehggg", "fgggg", "fhggg", "igggg", "ihggg", "jgggg", "jhggg", "kgggg", "khggg", "lgggg", "lhggg", "mgggg", "mhggg", "ngggg", "nhggg", "ogggg", "ohggg", "pgggg", "phggg", "hhggg", "hhagg", "hhahg", "hhbgg", "hhbhg", "hhcgg", "hhchg", "hhdgg", "hhdhg", "hhegg", "hhehg", "hhfgg", "hhfhg", "hhigg", "hhihg", "hhjgg", "hhjhg", "hhkgg", "hhkhg", "hhlgg", "hhlhg", "hhmgg", "hhmhg", "hhngg", "hhnhg", "hhogg", "hhohg", "hhpgg", "hhphg", "hhhhg", "ahhhg", "aihhg", "bhhhg", "bihhg", "chhhg", "cihhg", "dhhhg", "dihhg", "ehhhg", "eihhg", "fhhhg", "fihhg", "ghhhg", "gihhg", "jhhhg", "jihhg", "khhhg", "kihhg", "lhhhg", "lihhg", "mhhhg", "mihhg", "nhhhg", "nihhg", "ohhhg", "oihhg", "phhhg", "pihhg", "iihhg", "iiahg", "iiaig", "iibhg", "iibig", "iichg", "iicig", "iidhg", "iidig", "iiehg", "iieig", "iifhg", "iifig", "iighg", "iigig", "iijhg", "iijig", "iikhg", "iikig", "iilhg", "iilig", "iimhg", "iimig", "iinhg", "iinig", "iiohg", "iioig", "iiphg", "iipig", "iiiig", "aiiig", "ajiig", "biiig", "bjiig", "ciiig", "cjiig", "diiig", "djiig", "eiiig", "ejiig", "fiiig", "fjiig", "giiig", "gjiig", "hiiig", "hjiig", "kiiig", "kjiig", "liiig", "ljiig", "miiig", "mjiig", "niiig", "njiig", "oiiig", "ojiig", "piiig", "pjiig", "jjiig", "jjaig", "jjajg", "jjbig", "jjbjg", "jjcig", "jjcjg", "jjdig", "jjdjg", "jjeig", "jjejg", "jjfig", "jjfjg", "jjgig", "jjgjg", "jjhig", "jjhjg", "jjkig", "jjkjg", "jjlig", "jjljg", "jjmig", "jjmjg", "jjnig", "jjnjg", "jjoig", "jjojg", "jjpig", "jjpjg", "jjjjg", "ajjjg", "akjjg", "bjjjg", "bkjjg", "cjjjg", "ckjjg", "djjjg", "dkjjg", "ejjjg", "ekjjg", "fjjjg", "fkjjg", "gjjjg", "gkjjg", "hjjjg", "hkjjg", "ijjjg", "ikjjg", "ljjjg", "lkjjg", "mjjjg", "mkjjg", "njjjg", "nkjjg", "ojjjg", "okjjg", "pjjjg", "pkjjg", "kkjjg", "kkajg", "kkakg", "kkbjg", "kkbkg", "kkcjg", "kkckg", "kkdjg", "kkdkg", "kkejg", "kkekg", "kkfjg", "kkfkg", "kkgjg", "kkgkg", "kkhjg", "kkhkg", "kkijg", "kkikg", "kkljg", "kklkg", "kkmjg", "kkmkg", "kknjg", "kknkg", "kkojg", "kkokg", "kkpjg", "kkpkg", "kkkkg", "ggggx", "gggxx", "ggxxx", "gxxxx", "xxxxx", "xxxxy", "xxxyy", "xxyyy", "xyyyy", "yyyyy", "yyyyw", "yyyww", "yywww", "ywwww", "wwwww", "wwvww", "wvvww", "vvvww", "vvvwz", "avvwz", "aavwz", "aaawz", "aaaaz");
    _126WordLadder21 wordLadder2 = new _126WordLadder21();

    Object result = wordLadder2.findLadders(beginWord, endWord, wordDict);


    System.out.println(result);
  }

  public List<List<String>> findLadders(String start, String end, List<String> wordList) {
    Map<String, Set<String>> graph = bfs(start, end, new HashSet<>(wordList));
    System.out.println("bfs done");
    System.out.println(graph);
    // dfs(graph, start, end, new ArrayList<>());
    //  System.out.println(childVsParent);
    List<String> result = new ArrayList<>();
    dfs(end, start, result);
    return paths;
  }

  private void dfs(String end, String start, List<String> result) {
    result.add(end);
    Set<String> parents = childVsParent.get(end);
    if (parents == null && end.equals(start)) {
      System.out.println(result);
      List<String> revPath = new ArrayList<>(result);
      Collections.reverse(revPath);
      paths.add(revPath);
    } else {
      for (String p : parents) {
        dfs(p, start, result);
      }
    }
    result.remove(result.size() - 1);
  }

  List<List<String>> paths = new ArrayList<>();

  public void dfs(Map<String, Set<String>> graph, String beginWord, String endWord, List<String> path) {
    path.add(beginWord);
    if (beginWord.equals(endWord)) {
      //  System.out.println(path);
      paths.add(new ArrayList<>(path));
    } else if (graph.containsKey(beginWord)) {
      // return;
      for (String child : graph.get(beginWord)) {
        dfs(graph, child, endWord, path);
      }
    }
    path.remove(path.size() - 1);
  }

  private Map<String, Set<String>> childVsParent = new HashMap<>();

  private Map<String, Set<String>> bfs(String beginWord, String endWord, Set<String> wordDict) {
    Map<String, Set<String>> graph = new LinkedHashMap<>();
    wordDict.remove(beginWord);
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    boolean isEndWordFound = false;
    Set<String> nextLevel = new HashSet<>();
    Set<String> v = new HashSet<>();
    while (!q.isEmpty() && !isEndWordFound) {
      int size = q.size();
      boolean isEndWordFoundInLevel = false;
      for (int i = 0; i < size; i++) {
        String curr = q.poll();
        long ts = System.currentTimeMillis();
        Set<String> edges = getEdges(wordDict, curr);
        //  System.out.println("edges obtained: "+(System.currentTimeMillis() - ts));
        for (String child : edges) {
          if (child.equals(endWord)) {
            isEndWordFoundInLevel = true;
            System.out.println("matched");
          }
          graph.computeIfAbsent(curr, k -> new LinkedHashSet<>()).add(child);
          if (!nextLevel.contains(child)) {
            q.add(child);
            nextLevel.add(child);
          }
          childVsParent.computeIfAbsent(child, k -> new LinkedHashSet<>()).add(curr);
        }
      }
      wordDict.removeAll(nextLevel);
      nextLevel.clear();
      if (isEndWordFoundInLevel) {
        isEndWordFound = true;
      }
    }

    return graph;
  }

  private Set<String> getEdges(Set<String> words, String word) {
    Set<String> edges = new HashSet<>();
    for (String element : words) {
      if (!diffCount(element, word)) {
        continue;
      }
      edges.add(element);
    }
    return edges;
  }

  private boolean diffCount(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return count == 1;
  }

}
