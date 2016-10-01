import java.awt.{Color, Graphics}
import javax.swing.{JPanel, JFrame}

/**
 * Created by takeyuki on 15/12/19.
 */
object SimpleAnimation {
  var x :Double= 70
  val yTOP : Double= 70 //一番高い点
  var y : Double= 70


  class MyDrawPanel extends JPanel{
    override def paintComponent(g : Graphics){
      g.setColor(Color.green)
      g.fillRect(0,0,50,50)
//      println("called")
    }
  }

  def main(args: Array[String]) {
    val frame : JFrame = new JFrame("title!!")
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(800,600)
    frame.setVisible(true)

    val myDrawPanel = new MyDrawPanel
    myDrawPanel.setLayout(null)
    myDrawPanel.setBounds(x.toInt,y.toInt,100,100)
    frame.getContentPane.add(myDrawPanel)

    var t : Double = 0
    while(y < 550){
//      x += 1
      y = yTOP + distance(t)
      myDrawPanel.setBounds(x.toInt,y.toInt,100,100)
//      myDrawPanel.repaint()

      println(distance(t))
      t += 0.01
      try{
        Thread.sleep(10)
      }
    }
  }

  /*t秒後のｙの位置*/
  val g = 649.8 //重力加速度は9.8
  def distance(t : Double) = 0.5 * g * t*t

//  implicit class calGravity(t: Double){
//    def distance = 1/2 * 9.8 * t*t //重力加速度9.8
//  }
}
