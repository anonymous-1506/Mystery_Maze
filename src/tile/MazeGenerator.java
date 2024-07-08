package tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import main.gamepanel;

public class MazeGenerator {
	
	gamepanel gp;
    public int rows ;   // Number of rows in the maze
    public int cols;   // Number of columns in the maze
    private static final int WALL = 1;    // Representing walls as 1
    private static final int PATH = 0;    // Representing paths as 0
    private static final int[] DX = {0, 2, 0, -2}; // Movement in x direction (right, down, left, up)
    private static final int[] DY = {2, 0, -2, 0}; // Movement in y direction (down, right, up, left)

    public int[][] maze;
    private Random random;

    public MazeGenerator(gamepanel gp) {
    	this.gp = gp;
    	rows = gp.Rows;
    	cols = gp.Columns;
        this.rows = rows % 2 == 0 ? rows + 1 : rows;  // Ensure odd number of rows for proper maze
        this.cols = cols % 2 == 0 ? cols + 1 : cols;  // Ensure odd number of columns for proper maze
        maze = new int[this.rows][this.cols];
        random = new Random();
        initializeMaze();
        generateMaze();
    }
    
    // Initialize the maze with all walls
    private void initializeMaze() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                maze[y][x] = WALL;
            }
        }
    }

    // Generate the maze using randomized DFS
    public void generateMaze() {
        int startX = random.nextInt(cols / 2) * 2 + 1;
        int startY = random.nextInt(rows / 2) * 2 + 1;
        maze[startY][startX] = PATH;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            ArrayList<int[]> neighbors = getNeighbors(x, y);
            if (!neighbors.isEmpty()) {
                int[] neighbor = neighbors.get(random.nextInt(neighbors.size()));
                int nx = neighbor[0];
                int ny = neighbor[1];

                if (maze[ny][nx] == WALL) {
                    maze[(ny + y) / 2][(nx + x) / 2] = PATH;
                    maze[ny][nx] = PATH;
                    stack.push(new int[]{nx, ny});
                }
            } else {
                stack.pop();
            }
        }

        // Create openings at random edges
        createEdgeOpenings();
        polishedwall();
        includedoor();
        chest();
        obstacle();
        coinplacer();
    }
    //for obstacles:
    public void obstacle()
    {
    	int a = 2+(int)(Math.random()*4);
    	int starti[] = {0,4,10};
    	int endi[] = {3,9,12};
    	int startj[] = {3,3,10};
    	int endj[] = {9,9,12};
    	while(a > 0)
    	{	
    		boolean done = false;
    		int b = (int)(Math.random()*3);
    		for(int i = starti[b]; i <= endi[b];i++)
    		{
    			for(int j = startj[b]; j <= endj[b]; j++)
    			{
    				if(maze[i][j] == 0 && maze[i][j-1] == 1 && maze[i][j+1] == 1)
    				{
    					maze[i][j] = 5;
    					done = true;
    					break;
    				}
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    		a--;
    	}
    	
    }
    //for the compulsory door:
    public void includedoor()
    {
    	boolean done = false;
    	for(int i = 0; i < rows-5; i++)
    	{
    		for(int j = 0; j< cols; j++)
    		{
    			if(maze[i][j] == 0)
    			{
    				if(maze[i+1][j] == 0)
    				{
    					maze[i][j] = 3;
    					done = true;
    					break;
    				}
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    	}
    }
  //chest position:
    public int  chesti()
    {
    	boolean done = false;
    	int ret = 0;
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j< cols; j++)
    		{
    			if(maze[i][j] == 4)
    			{
    					ret = i;
    					done = true;
    					break;
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    	}
    	return ret;
    }
    public int  chestj()
    {
    	boolean done = false;
    	int ret = 0;
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j< cols; j++)
    		{
    			if(maze[i][j] == 4)
    			{
    					ret = j;
    					done = true;
    					break;
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    	}
    	return ret;
    }
    //door position:
    public int  doori()
    {
    	boolean done = false;
    	int ret = 0;
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j< cols; j++)
    		{
    			if(maze[i][j] == 3)
    			{
    					ret = i;
    					done = true;
    					break;
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    	}
    	return ret;
    }
    public int  doorj()
    {
    	boolean done = false;
    	int ret = 0;
    	for(int i = 0; i < rows; i++)
    	{
    		for(int j = 0; j< cols; j++)
    		{
    			if(maze[i][j] == 3)
    			{
    					ret = j;
    					done = true;
    					break;
    			}
    			if(done)
    			{
    				break;
    			}
    		}
    	}
    	return ret;
    }
    //to include the 3rd tile:
    public void polishedwall() {
    	for(int i = 0; i < rows; i++)
    	{
    		for (int j = 0; j < cols; j++)
    		{
    			if(maze[i][j] == 1)
    			{
    				if(i == rows - 1)
    				{
    					maze[i][j] = 2;
    				}
    				else if(i != rows - 1)
    				{
    					if( maze[i+1][j] != 1)
    					{
    						maze[i][j] = 2;
    					}
    				}
    			}
    		}
    	}
    }
    //to include the chest;
    public void chest()
    {
    	int ret = 0;
    	boolean done = false;
    	for(int i = rows/2 - 3; i <= rows/2 + 3; i++)
    	{
    		for(int j = cols/2 - 3; j <= cols/2 + 3; j++)
    		{
    			if(maze[i][j] == 0)
    			{
    				maze[i][j] = 4;
    				done = true;
    				break;
    			}
    		}
    		if(done)
    		{
    			break;
    		}
    	}	
    }
    //to get initial position for our hero randomly :
    public int getInitial()
    {	
    	int ret = 0;
    	boolean done = false;
    	for(int j = rows - 1; j >=0; j--)
    	{
    		for(int i = 0; i < cols; i++)
        	{
        		if(maze[j][i] == 0)
        		{
        			ret = i;
        			done = true;
        			break;
        		}
        	}
    		if(done)
    		{
    			break;
    		}
    	}
    	return ret;
    }
    //get coins:
public void coinplacer()
{
    int a =10;
    while(a > 0)
    {	
    	int x,y;
    	do
    	{
    	 x = (int)(1 + Math.random()*(cols-1));
    	 y = (int)(1 + Math.random()*(rows - 1));
    	}while(getMaze(y,x) != 0);
    	maze[y][x] = 6;
    	a--;
    }
    
}
public void updateCoin()
{
	int X = gp.player.x;
	int Y = gp.player.y;
	for(int i =0; i <  rows;i++)
	{
		for(int j =0; j< cols;j++)
		{
			if(maze[i][j] == 6)
			{
				if(Math.abs((j*gp.tile_size_net) - X )<= 20 && Math.abs((i*gp.tile_size_net) - Y )<= 20)
				{
					maze[i][j] = 0;
					gp.coin_score += 10;
				}
			}
		}
	}
}
    
  //for the initial position of key:    
    public int get_initialX_Key()
    {
    	int ret = 0;
    	boolean done = false;
    	for(int i = 7; i <rows; i++)
    	{
    		for(int j = 10; j <= 12; j++)
    		{
    			if(maze[i][j] == 0)
    			{
    				ret = i-1;
    				done = true;
    				break;
    			}
    		}
    		if(done)
    		{
    			break;
    		}
    	}
    	return ret;
    }
    public int get_initialY_Key(int target)
    {
    	int ret = 0;
    	boolean done = false;
    	for(int i = 7; i < rows; i++)
    	{
    		for(int j = 10; j <cols; j++)
    		{
    			if(i == target && maze[i][j] == 0)
    			{
    				ret = j+1;
    				done = true;
    				break;
    			}
    		}
    		if(done)
    		{
    			break;
    		}
    	}
    	return ret;
    }

    // Create random openings on the maze edges
    private void createEdgeOpenings() {
        int openings = random.nextInt(rows / 2) + random.nextInt(cols / 2);
        for (int i = 0; i < openings; i++) {
            if (random.nextBoolean()) {
                // Open random edge on the top or bottom
                int x = random.nextInt(cols / 2) * 2 + 1;
                maze[0][x] = PATH;
                maze[rows - 1][x] = PATH;
            } else {
                // Open random edge on the left or right
                int y = random.nextInt(rows / 2) * 2 + 1;
                maze[y][0] = PATH;
                maze[y][cols - 1] = PATH;
            }
        }
    }

    // Get valid neighbors for the current cell
    private ArrayList<int[]> getNeighbors(int x, int y) {
        ArrayList<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            if (nx > 0 && nx < cols - 1 && ny > 0 && ny < rows - 1 && maze[ny][nx] == WALL) {
                neighbors.add(new int[]{nx, ny});
            }
        }
        Collections.shuffle(neighbors);
        return neighbors;
    }

    // Get the maze array
    public int getMaze(int i,int j) {
        return maze[i][j];
    }
    
 // Get the maze array
    public boolean getMazeBool(int i,int j) {
        int check = maze[i][j];
        boolean check1 = gp.tilem.tiles[check].collision;
        if(check1)
        {
        	return true;
        }
        else
        {
        	return false;
        }
        
    }
    

}