// 1184. Distance Between Bus Stops
// A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
// The bus goes along both directions i.e. clockwise and counterclockwise.
// Return the shortest distance between the given start and destination stops.
// Example 1:
// Input: distance = [1,2,3,4], start = 0, destination = 1
// Output: 1
// Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.

// CODE

class Solution {
    public int distanceBetweenBusStops(final int[] distance, final int start, final int destination) {
        if(start == destination)
            return 0;

        final int n = distance.length;

        int d = distance[start], right = Integer.MAX_VALUE, i = (start + 1) % n;

        while(i != start) {
            if(i == destination) {
                right = d;
                d = 0;
            }

            d += distance[i];

            i++;
            i %= n;
        }

        return Math.min(d, right);
    }
}
