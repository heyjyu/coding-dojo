/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (true) {
            int mid = (int) Math.floor(((long) low + high) / 2);

            if (isBadVersion(mid) == true && isBadVersion(mid - 1) == false) {
                return mid;
            }

            if (!isBadVersion(mid)) {
                low = mid + 1;
                continue;
            }

            high = mid - 1;
        }
    }
}
