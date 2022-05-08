## Trie

- Trie Data Structure is used for fast retrieval
- Every Trie node can hold only one character 
- The characters that can be used are predetermined or limited. To handle special/numeric characters, logic has to be written as the position of a character will remain the same.
- If there are n allowed characters, every Trie Node will be initialized with n such Trie Node. This has a toll on space complexity
- Inserting/Finding an element will take - O(S), S - length of the word to be inserted
- Space Complexity - O(ALLOWED_ALPHABET_SIZE * MAX_LENGTH * TOTAL_WORDS )
