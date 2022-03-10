// quick-find and quick-union can't support larger dynamic connectivity problems

/**
 * Improvement 1: weighting
 * 
 *  Weighted quick-union:
 *      - Modify quick-union to avoid tall trees.
 *      - Keep track of size of each tree (number of objects).
 *      - Balance by linking root of smaller tree to root of larger tree. -- (reasonable alternatives: union by height or "rank")
 * 
 *  in a weighted tree, we always put the smaller tree lower
 * 
 * Implementation:
 * 
 *  Data structure. Same as quick-union, but maintain extra array sz[i] to count number of objects in the tree rooted at i.
 * 
 *  Find. Identical to quick-union.
 *      // return root(p) == root(q);
 * 
 *  Union. Modify quick-union to:
 *      - Link root of smaller tree to root of larger tree.
 *      - Update the sz[] array.
 *          // int i = root(p);
 *          // int j = root(q);
 *          // if (i == j) return;
 *          // if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
 *          // else               { id[j] = i; sz[i] += sz[j]; }
 * 
 *  Running time.
 *      - Find: takes time proportional to depth of p and q.
 *      - Union: takes constant time, given roots.
 * 
 *  Proposition. Depth of any node x is at most lg(N). (lg = base-2 logarithm)
 * 
 *  Proof (notated hence Pf). When does depth of x increase?
 *      Increased by 1 when tree T[1] containing x is merged into another tree T[2].
 *          - The size of the tree containing x at least doubles since |T[2]| >= |T[1]|.
 *          - Size of tree containing x can double at most lg(N) times. Why?
 *                  When does the depth of any node increase? The x's depth will increase by 1 when its' tree (T[1]) is merged into some other tree (T[2])
 *                  At that point, we'll only do that if the size of T2 was bigger or equal to the size of T1.
 */

 /**
  * Improvement 2: path compression
  * 
  *  Quick union with path compression. Just after computing the root of p, set the id of each examined node to point to that root.
  */