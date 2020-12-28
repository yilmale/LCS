package lcs

import Constants.{rng}

trait Scenario[Condition,Action,Reward] {
  var remainingCycles : Int
  var possibleActions : List[Action]
  var steps : Int
  def getPossibleActions : List[Action] = possibleActions
  def more : Boolean
  def reset : Unit
  def sense : (Condition,Action)
  def execute(action: Action) : Reward
}

class MultiplexProblem(cycles: Int) extends Scenario[Condition,Phenotype,Boolean] {
  type Instance = (Condition,Phenotype)
  var filename = "/Users/yilmaz/IdeaProjects/LCS/src/main/scala/6MultiplexerData.txt"
  var  dm = new DataManagement()
  var data : Array[(Condition,Phenotype)] = dm.loadFile(filename,6).toArray
  var index : Int = 0
  var steps : Int = 0
  var currentSituation : Option[Instance] = None
  var remainingCycles : Int = cycles
  var possibleActions : List[Phenotype] = List(Phenotype("0"),Phenotype("1"))
  def more : Boolean = {
    remainingCycles > 0
  }

  def reset: Unit = {
    remainingCycles = cycles
    rng = new scala.util.Random()
    index = 0
    steps = 0
  }

  def sense : (Condition,Phenotype) = {
    val instance = data(index)
    currentSituation = Some(instance)
    index = (index + 1) % data.length
    instance
  }

  def execute(action: Phenotype): Boolean = {
    var reward : Boolean = false
    remainingCycles = remainingCycles - 1
    steps = steps + 1
    (action.data.get.bits.equals(currentSituation.get._2.data.get.bits))
  }

}


class LCSOmegaProblem(cycles: Int) extends Scenario[Condition,Phenotype,Boolean] {
  type Instance = (Condition,Phenotype)
  var filename = "/Users/yilmaz/IdeaProjects/LCS/src/main/scala/LCSOmegaData.txt"
  var  dm = new DataManagement()
  var data : Array[(Condition,Phenotype)] = dm.loadFile(filename,3).toArray
  var index : Int = 0
  var steps : Int = 0
  var currentSituation : Option[Instance] = None
  var remainingCycles : Int = cycles
  var possibleActions : List[Phenotype] = List(Phenotype("0"),Phenotype("1"))
  def more : Boolean = {
    remainingCycles > 0
  }

  def reset: Unit = {
    remainingCycles = cycles
    rng = new scala.util.Random()
    index = 0
    steps = 0
  }

  def sense : (Condition,Phenotype) = {
    val instance = data(index)
    currentSituation = Some(instance)
    index = (index + 1) % data.length
    instance
  }

  def execute(action: Phenotype): Boolean = {
    var reward : Boolean = false
    remainingCycles = remainingCycles - 1
    steps = steps + 1
    (action.data.get.bits.equals(currentSituation.get._2.data.get.bits))
  }

}

