/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null||points.length==0)
            return 0;
        if(points.length==1||points.length==2)
            return points.length;
        HashMap<Double,Integer> map =new HashMap<Double,Integer>();
        double k;
        int max=1,temp;
        for(int i=0;i<points.length;i++)
        {
            temp=1;
            map.clear();
            for(int j=0;j<points.length;j++)
            {
                if(i==j)
                    continue;
                if(points[i].x==points[j].x&&points[i].y==points[j].y)
                {
                    temp++;
                    continue;
                }
                k = points[i].x==points[j].x ? Double.MAX_VALUE:((double)points[j].y - (double)points[i].y)/((double)points[j].x - (double)points[i].x);
                if(map.containsKey(k))
                    map.put(k,map.get(k)+1);
                else
                    map.put(k,1);
            }
            int count=0;
            for(Integer tmpint:map.values())
                if(tmpint>count)
                    count=tmpint;
            count+=temp;
            if(count>max)
                max=count;
        }
        return max;
    }
}