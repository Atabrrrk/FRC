// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team6429.periodics.Auto.AutoModes.MainAuto;

import java.util.Arrays;

import frc.team6429.periodics.Auto.AutoModeEndedException;
import frc.team6429.periodics.Auto.Action.DumperAction;
import frc.team6429.periodics.Auto.Action.FourDimensionalTrajectory;
import frc.team6429.periodics.Auto.Action.ParallelAction;
import frc.team6429.periodics.Auto.Action.RemasteredFourDimensional;
import frc.team6429.periodics.Auto.Action.SeriesAction;
import frc.team6429.periodics.Auto.Action.TrajectoryIndexerAction;
import frc.team6429.periodics.Auto.Action.CreateTrajectoryAction.PathType;
import frc.team6429.periodics.Auto.AutoModes.AutoModeBase;
import frc.team6429.robot.Constants;
import frc.team6429.robot.RobotData;
import frc.team6429.robot.RobotData.InSync;
import frc.team6429.periodics.Auto.Action.DriveAction;

/** Add your docs here. */
public class ThreeCargoAuto extends AutoModeBase{

    public PathType _path;

    public ThreeCargoAuto(PathType path){
        _path =  path;
    }

    @Override
    protected void routine() throws AutoModeEndedException {
            runAction(new SeriesAction(Arrays.asList(
                new ParallelAction(Arrays.asList(
                    new RemasteredFourDimensional(RobotData.threeCargo.get(0)),
                    new TrajectoryIndexerAction(Constants.pivotTime(0), 1, 0.75)
                )),
                new SeriesAction(Arrays.asList(
                    new RemasteredFourDimensional(RobotData.threeCargo.get(1)),
                    new DumperAction(InSync.INSYNC, 1, 1, 1, Constants.dumperTime(0))
                )),
                new ParallelAction(Arrays.asList(
                    new RemasteredFourDimensional(RobotData.threeCargo.get(2)),
                    new TrajectoryIndexerAction(Constants.pivotTime(0), 1, 0.75)
                )),
                new SeriesAction(Arrays.asList(
                    new RemasteredFourDimensional(RobotData.threeCargo.get(3)),
                    new DumperAction(InSync.INSYNC, 1, 1, 1, Constants.dumperTime(0))
                ))
            ))
        );
        
    }
    
}
   /* @Override
    protected void routine() throws AutoModeEndedException {
        runAction(new SeriesAction(Arrays.asList(
                        new ParallelAction(Arrays.asList(
                            new FourDimensionalTrajectory(),
                            new SeriesAction(Arrays.asList(
                                new TrajectoryIndexerAction(1, InSync.INSYNC, 1, 0.75),
                                new SeriesAction(
                                    new DumperAction(InSync.INSYNC, 1, 1, 1, 1.5),
                                    new ParallelAction(Arrays.asList(
                                        new FourDimensionalTrajectory(),
                                        new TrajectoryIndexerAction(1.5, InSync.INSYNC, 1, 0.75),
                                            new SeriesAction(Arrays.asList(
                                                new FourDimensionalTrajectory(),
                                                new DumperAction(InSync.INSYNC, 1, 1, 1, 1.5)
                                                )),
                                                new FourDimensionalTrajectory()
                                            ))
                                    ))
                                ))
                        ))
                ));
    }
}*/