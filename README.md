<h1>Game a Thon</h1>
<h2>MYSTERY_MAZE</h2>
<h4>LIST OF MILESTONES MET AND TO WHAT DEGREE WERE THEY MET</h4>
<ol>
  <li>MILESTONE 1: 100%</li>
  <li>MILESTONE 2: 100%</li>
  <li>MILESTONE 3: 100%</li>
  <li>MILESTONE 4: 0%</li>
  <li>MILSTONE 5: 100%</li>
  <li>MILSTONE 6: 100%</li>
  <li>MILSTONE 7: 0%</li>
  <li>MILSTONE 8: 50%</li>
</ol>
<h3>  A Summary of how different MileStones were met</h3>
<OL>
  <LI><h2>MILESTONE 1: </h2>
  <p>Requirements</p>
  <ul>
    <li>Implement a basic maze generation algorithm, such as depth-first search or recursive backtracking.</li>
    <li>Ensure the paths lead to dead ends, exit doors, or hidden treasures.</li>
    <li>Introduce spike obstacles that the player must avoid.</li>
    <li>Randomly generate the maze each time for enhanced replayability.</li>
  </ul>
    <p>Implementations for the same</p>
    <ul>
      <li>For generating the maze, I used the a DFS based Algorithm.
      <li>The paths as of now lead to a Door(at roughly the top of the maze),a Treasure Chest (roughly the center or middle portion) and a lot of dead ends.
      <li>There are spike obstacles that are generated randomly(number of them : 1 to 4 randomly , can make it level dependent later).
      <li>The maze generated as of now is unique for every gameplay.
    </ul>
    <img src = "https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/5863330a-3ee4-40f6-93fc-b0661598eb40" height = "720" width = "960">
  </li>
  <li>
    <h2>MILESTONE 2:</h2>
    <li>
  <h2>Milestone 2:</h2>
  <p>Requirements</p>
  <ul>
    <li>Allow the player character to move left, right, up, and down using touch controls, WASD keys, or arrow keys.
    <li>Implement player movement and collision detection with maze walls.
    <li>Enable the spacebar or a double-tap key to drop a bomb.
  </ul>
  <p>Implementations</p>
  <ul>
    <li>The Player movements are controlled by W/S/A/D.
    <li>Collision system with Maze walls, Door(prior to key collection) and spiked walls is implemented.
    <li><b>Bomb Deployment is interactive. We can use UP/DOWN/LEFT/RIGHT keys to deploy a bomb in the same direction.</b></li>
  </ul>
<img src = "https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/ffc7e434-3a0c-4e8d-9285-8abcd07c4138"  height = "720" width = "960" >
</li>
  <li>
  <h2>Milestone 3:</h2>
  <p>Requirements</p>
  <ul>
    <li>Use the provided graphics for the maze, player, AI agent, bombs, treasures, and coins.
    <li>Create a basic user interface featuring a start screen, an in-game HUD (displaying timer and score), and an end screen.
    <li>Developers can use their custom assets instead of the UI assets provided by us.
  </ul>
  <p>Implementations</p>
  <ul>
    <li>A mix of Custom assets and Provided asssets are used in this step. Especially for the player and the enemy(who sadly isnt implemented by the time of submission), I used custom assets.
    <li>An interactive UI is implemented with multiple options in different gamestates(including a pause feature.)
    <li>Below are the Screenshots of different UI features.
  </ul>
    <p>1.The Menu State Screen.The 3 buttons lead to GamePlay,Instructions and Quitting the game respectively.Use Arrow keys to choose buttons and click enter to select one.</p>
    <image src ="https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/af02f47e-e5dd-44a3-ba03-c2244db2efb1" height = "720" width = "960">
  ![Menu](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/af02f47e-e5dd-44a3-ba03-c2244db2efb1)
  <p>2.The Instructions page.</p>
    <image src ="https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/c5a7a0a1-78ff-45db-a703-e1ae01d98496" height = "720" width = "960">
      ![Instructions](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/c5a7a0a1-78ff-45db-a703-e1ae01d98496)
    <p>3.GameOver due to Timeup.</p>
    <image src ="https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/cfc1272e-ae0d-4ef6-88dc-e8cf4f55dbf6" height = "720" width = "960">
  ![Gameover](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/cfc1272e-ae0d-4ef6-88dc-e8cf4f55dbf6)
  <p>4.GameOver due to Death.</p>
    <image src ="https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/3b5347ed-ba74-46af-88c4-0813c50fb06d" height = "720" width = "960">
![death](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/3b5347ed-ba74-46af-88c4-0813c50fb06d)

  <p>5.VICTORY</p>
    <image src ="https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/e98b578c-8904-4f9f-bbf4-7e9bdba5ee6d" height = "720" width = "960">
  ![Victory](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/e98b578c-8904-4f9f-bbf4-7e9bdba5ee6d)
      <p>Image showing Pause State in the game.</p>
      <img src = "https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/7bdf8441-9bbf-400e-a250-85c1d200843d"  height = "720" width = "960" >
![Screenshot 2024-07-09 020306](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/7bdf8441-9bbf-400e-a250-85c1d200843d)
    </li>
    <li>
  <h>Milestone 5 and 6 :</h2>:
  <p>Requirements</p>
  <ul>
    <li>- Implement a timer to track maze completion time.
    <li>- Develop a scoring system based on time and collected items (treasures and coins).
    <li>- Display the status of remaining bombs.
    <li>-Each coin awards 10 points to the player.
    <li>- A treasure box, placed randomly in the maze, awards 100 points upon collection.
    <li>- Randomly distribute treasures and coins throughout the maze.
    <li>- Implement logic for collecting treasures and coins.
  </ul>
  <p>Implementations</p>
  <ul>
    <li>A timer of 60 seconds is set and the time remaining is displayed on the Top Left Corner.
    <li>The Scorimg System is as given in th ProblemStatement 
    <li>Reamining Bombs, collected key and coins all appear on the top right corner of the screen.
  </ul>
      <image src = "https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/017c1834-34fa-434c-b5db-9ccdc76becda" height = "720" width = "960">
![Screenshot 2024-07-09 020306](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/017c1834-34fa-434c-b5db-9ccdc76becda)
      <image src = "https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/6c2942ee-dab8-4ddd-a5e1-93309844d604" height = "720" width = "960"
</li>![Screenshot 2024-07-09 020417](https://github.com/anonymous-1506/Mystery_Maze/assets/148906347/6c2942ee-dab8-4ddd-a5e1-93309844d604)
  <li>
    <h>Milestone 8 :</h2>
    <p>Requirements</p>
  <ul>
    <li>-Polish the game by adding sound effects and minor visual improvements.
<li>- Include a bomb flash visual effect.
<l1>- Test the game for bugs and fix any issues.
<li>- Handle unexpected crashes.
<li>- Optimize code for reduced processing and memory usage.
<li>- Feel free to unleash your creativity by adding new features or enhancing the gameplay to make it more engaging.
  </ul>
  <p>Implementations</p>
  <ul>
    <li>Basic Sound Effects when an object is slelected is included
    <li>Two samll bugs , one related to the Timer and the other related to Scoring System were fixed just after the deadline.
      
  </ul>
  </li>
</OL>
