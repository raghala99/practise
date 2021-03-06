# Audio Song Player
I have 2 design approaches for building an audio player.

1) Using Arrays.
2) Using Circular Doubly LinkedList

I am taking the implementation using Arrays. Because it's Time Complexity is always O(1).

Using Arrays Implementation
===========================

I am defining the class name as AudioPlayer and implementing the 3 methods.

1) play() -- Which always select the random song to play using index number.

2) next() -- Which always play an next to the currently playing/played song.

3) previous() -- which always play a previous to the currently playing/played song.

Here is the small snippet for all the functionality.
----------------------------------------------------

1) Play() functionality is designed to play an random song using array index, which return by the java.util.Random().nextInt(SIZE_OF_ARRAY).

Once getting random number will replace the "random" number to "size-1" of array. So that for every song played will move the played song position to last of the size-1 array position.

Explanation:
------------

For example:

we have 4 songs in the playlist as below

[a, b, c, d]  and are indexes [0 to 3] respectively. When we call the play() function it get's an random number from the SIZE=4. Assume that we got an 2 index as random number. In such cases will play "c" song and shift the 2 index value to "SIZE - 1" position. After that our playlist will be as below [a, b, d, c] and SIZE of the variable decremented, Now SIZE = 3. We will play the songs until SIZE is getting ZERO(SIZE = 0).

2) Next() functionality is designed to play the next song to the currently playing/played song. Here Always we maintain current song index value. so that we can play the next song by incrementing the current song index(currentIndex).

3) Previous() functionality is designed to play a previous song to the currently playing/played song. Here Always we maintain current song index value. so that we can play the next song by decrementing the current song index(currentIndex).

Here the time complexity of the algorithm is always O(1).

Using Circular Doubly LinkedList Implementation (Not Implemented, Just it is design approach)
==============================================================================================

For Doubly linked list we have to design node as 

Class Node<T> {
  T value;
  Node next;
  Node previous;
}

In the above class representation

1) "value"  attribute is used to store the value of file or filename.
2) "next" attribute is used to store the value of the next node.
3) "previous" attribute is used to store the value of the previous node

Whenever we are making a playlist using circular linked list we have to store corresponding node information to the HashMap to de-refer the node from LinkedList, when it is played. It is a memory overloaded approach.

We need a extra memory space for to read random song, For sequential playing it doesn't required a extra HashMap memory. From the root node we move forward and backwared after once it is playing just de-list from LinkedList.

Here also time complexity is O(1) but we need Extra space to retain for every node information in HashMap.


