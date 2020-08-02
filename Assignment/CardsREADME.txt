Here user is Entering a sequence of cardswhich we have to monitor whether its valid or not.

Firstly, i have defined CheckSeq(seq) method in which we pass the seq entered by user...eg {"H#A","H#2","H#3","H#4"}; 

Now basic logic here is..
1.  I am checking for suits of the sequence first.
If suits itself are not similar for the user sequence, then directly returning "Not valid sequence".
If suits are similar then calling addRank(suit);

Coming to addRank(suit)
here adding A to K ranks of deck to the sequence Suit and creating a Rankarr[] here.
And passing the Rankarr[] to the method validsequence(rankarr).

Coming to validsequence(rankarr) here i am comparing two lists...
first--Converting our RankArray to list(list)
second--Converting the user sequence arr in list(templist)

Now, checking the index from list for templist[0] value;
once i get the index, I am applying loop on templist length
and retriving further values from the (list) starting from the index retrieved previously, and then storing into finalList.

At the end i am just Comparing my tempList with finalList;
If its Equal then its a Valid Sequence
If its not Equal then its a Unvalid Sequence.



