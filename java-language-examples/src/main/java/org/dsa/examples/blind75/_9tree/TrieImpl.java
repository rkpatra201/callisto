package org.dsa.examples.blind75._9tree;

import java.util.UUID;

public class TrieImpl {

  private static class TrieNode {
    private boolean lastNode;
    private TrieNode[] children; // Fixed array instead of HashMap

    public TrieNode() {
      children = new TrieNode[36]; // Supports a-z and 0-9 for UUIDs
      lastNode = false;
    }
  }

  private static class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    private int getIndex(char c) {
      if (Character.isDigit(c)) return c - '0' + 26; // Map '0'-'9' to 26-35
      return c - 'a'; // Map 'a'-'z' to 0-25
    }

    public void insert(String input) {
      TrieNode current = root;
      for (char c : input.toCharArray()) {
        int index = getIndex(c);
        if (current.children[index] == null) {
          current.children[index] = new TrieNode();
        }
        current = current.children[index];
      }
      current.lastNode = true;
    }

    public boolean exists(String input) {
      TrieNode current = root;
      for (char c : input.toCharArray()) {
        int index = getIndex(c);
        if (current.children[index] == null) {
          return false;
        }
        current = current.children[index];
      }
      return current.lastNode;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    long uuidCount = 18*1_000_000_000_000L; // Store 18 billion UUIDs

    for (long i = 0; i < uuidCount; i++) {
      String id = UUID.randomUUID().toString().replace("-", ""); // Remove dashes for efficiency
      trie.insert(id);
      if (i % 100_000 == 0) {
        System.out.println("Inserted: " + i);
      }
    }

    // Check if a UUID exists
    String testUUID = UUID.randomUUID().toString().replace("-", "");
    System.out.println("Exists (" + testUUID + "): " + trie.exists(testUUID));
  }
}
