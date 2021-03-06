/*
 * Cecilio Valle 
 * CS480
 * Lab 3
 */
package calc;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author cs427001_23
 */
public class CalcFrame extends javax.swing.JFrame {
    

     
    ArrayList<String> postNums = new ArrayList<>(); 
    /**
     * Creates new form CalcFrame
     * @param input
     * @return 
     */
    public boolean isDouble(String input){
        try{
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e){
            return false; 
    }
    }    
    public boolean aOper(char c){ // check to see if operator 
        if (c == '+'||c == '-'||c == '*'||c == '/'||c == '^'||
            c == '('||c == ')'||c == '['||c == ']'||c == '{'
            ||c == '}'||c == 's'||c == 'c'||c == 't'){
            return true;
        }else {
            return false;
        }//if else 
    }//aOper
    
    public boolean opPrecedence (char x, char y){ //setting precednece
       
        switch (x){//set presedence 
            case '+':
            case '-':
                return !( y == '+' || y == '-');
            case '*':
            case '/':
                return !(y == '*' || y == '/');
            case 's':
            case 'c':
            case 't':
                return (y == '^' || y == '{');
            case '^':
                return (y == '{'); 
            case '{':
                return true; 
            case '[':
                return true; 
            case '(':
                return true; 
            default: 
                return false; 
        }//switch 
    }//opPresedence
    
    public CalcFrame() {
        initComponents();
    }
    
    public String parseAll (String input){ //parse input into postfix
        Stack<String> nums = new Stack<String> ();
        if (!input.isEmpty()){
            char myChar; 
            StringTokenizer art = new StringTokenizer (input,"+-*/()^[]{}sct",true);
            while (art.hasMoreTokens()){
                
               String current = art.nextToken();
               myChar = current.charAt(0);
               
               if (( current.length()==1) && aOper(myChar)){
                   
                   while(!nums.empty() && 
                        !opPrecedence(((String)nums.peek()).charAt(0),myChar))
                        postNums.add((String)nums.pop());
                   
                   switch (myChar) {
                       case ')':
                           {
                               String op;
                               op = (String)nums.pop();
                               while (op.charAt(0)!= '('){
                                   postNums.add(op);
                                   op = (String)nums.pop();
                               }//while
                               break;
                           }
                       case '}':
                           {
                               String op;
                               op = (String)nums.pop();
                               while (op.charAt(0)!= '{'){
                                   postNums.add(op);
                                   op = (String)nums.pop();
                               }//while
                               break;
                           }
                       case ']':
                           {
                               String op;
                               op = (String)nums.pop();
                               while (op.charAt(0)!= '['){
                                   postNums.add(op);
                                   op = (String)nums.pop();
                               }//while
                               break;
                           }
                       default:
                           nums.push(current);
                           break; //if
                   }
               } else {
          
                   postNums.add(current);
               }// if 
               //System.out.println(nums.size()+"size");
            }//while loop
            
            while (!nums.empty())
                postNums.add((String)nums.pop());
            
            System.out.println(postNums);
            postFix(postNums); 
            return postNums.toString( );
        }else{
            nums.push("Enter Vallid Input");
            return nums.pop(); 
           
        }//if statement
        
    }//parseAll

    
    public void postFix(ArrayList input){ //postfix arthmetic
        Stack<Double> post = new Stack<>(); 
            for (int i = 0; i < input.size();i++){
                double a = 0; 
                double b = 0;  
                String curIn = input.get(i).toString();
                if (isDouble(curIn)){
                    double temp = Double.parseDouble(curIn);
                    post.push(temp);
                }else{
                    switch (curIn){
                        case "s":
                            a = Math.toRadians(post.pop());
                            post.push(Math.sin(a));
                            break;
                        case "c":
                            a = Math.toRadians(post.pop());
                            post.push(Math.cos(a));
                            break;
                        case "t":
                            a = Math.toRadians(post.pop());
                            post.push(Math.tan(a)); 
                            break;
                        case"+":
                             a = post.pop();
                             b = post.pop();
                             post.push(a+b);
                             break;
                        case "-":
                            a = post.pop();
                            b = post.pop();
                            post.push(b-a);  
                            break;
                        case"^":
                            a = post.pop();
                            b = post.pop();
                            post.push(Math.pow(b, a)); 
                            break;
                        case"*":
                            a = post.pop();
                            b = post.pop();
                            post.push(a*b); 
                            break;
                        case"/":
                            a = post.pop();
                            b = post.pop();
                            post.push(b/a);  
                            break;
                        default:
                            break;
                    }//switch 
                }//if
            } //System.out.print(post); 
        double res = post.pop(); 
        System.out.print("Result:"+res);
        Result.setText(String.valueOf(res));
        postNums.clear();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Result = new javax.swing.JTextField();
        Num7 = new javax.swing.JButton();
        Num8 = new javax.swing.JButton();
        Num9 = new javax.swing.JButton();
        Num4 = new javax.swing.JButton();
        Num5 = new javax.swing.JButton();
        Num6 = new javax.swing.JButton();
        Num1 = new javax.swing.JButton();
        Num2 = new javax.swing.JButton();
        Num3 = new javax.swing.JButton();
        LPan = new javax.swing.JButton();
        Num0 = new javax.swing.JButton();
        RPant = new javax.swing.JButton();
        AddButt = new javax.swing.JButton();
        MinusButt = new javax.swing.JButton();
        MultButt = new javax.swing.JButton();
        DivideButt = new javax.swing.JButton();
        ExpButt = new javax.swing.JButton();
        ClearButt = new javax.swing.JButton();
        EqButt = new javax.swing.JButton();
        lBrac = new javax.swing.JButton();
        rBrac = new javax.swing.JButton();
        lCurl = new javax.swing.JButton();
        rCurl = new javax.swing.JButton();
        sinBut = new javax.swing.JButton();
        cosBut = new javax.swing.JButton();
        tanBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Result.setEditable(false);
        Result.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Result.setToolTipText("");
        Result.setSelectionColor(new java.awt.Color(204, 0, 204));
        Result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultActionPerformed(evt);
            }
        });

        Num7.setText("7");
        Num7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num7ActionPerformed(evt);
            }
        });

        Num8.setText("8");
        Num8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num8ActionPerformed(evt);
            }
        });

        Num9.setText("9");
        Num9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num9ActionPerformed(evt);
            }
        });

        Num4.setText("4");
        Num4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num4ActionPerformed(evt);
            }
        });

        Num5.setText("5");
        Num5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num5ActionPerformed(evt);
            }
        });

        Num6.setText("6");
        Num6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num6ActionPerformed(evt);
            }
        });

        Num1.setText("1");
        Num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num1ActionPerformed(evt);
            }
        });

        Num2.setText("2");
        Num2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num2ActionPerformed(evt);
            }
        });

        Num3.setText("3");
        Num3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num3ActionPerformed(evt);
            }
        });

        LPan.setText("(");
        LPan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LPanActionPerformed(evt);
            }
        });

        Num0.setText("0");
        Num0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Num0ActionPerformed(evt);
            }
        });

        RPant.setText(")");
        RPant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPantActionPerformed(evt);
            }
        });

        AddButt.setText("+");
        AddButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtActionPerformed(evt);
            }
        });

        MinusButt.setText("-");
        MinusButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusButtActionPerformed(evt);
            }
        });

        MultButt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MultButt.setText("*");
        MultButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultButtActionPerformed(evt);
            }
        });

        DivideButt.setText("/");
        DivideButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivideButtActionPerformed(evt);
            }
        });

        ExpButt.setText("^");
        ExpButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpButtActionPerformed(evt);
            }
        });

        ClearButt.setText("C");
        ClearButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtActionPerformed(evt);
            }
        });

        EqButt.setText("=");
        EqButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqButtActionPerformed(evt);
            }
        });

        lBrac.setText("[");
        lBrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lBracActionPerformed(evt);
            }
        });

        rBrac.setText("]");
        rBrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBracActionPerformed(evt);
            }
        });

        lCurl.setText("{");
        lCurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lCurlActionPerformed(evt);
            }
        });

        rCurl.setText("}");
        rCurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCurlActionPerformed(evt);
            }
        });

        sinBut.setText("sin");
        sinBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinButActionPerformed(evt);
            }
        });

        cosBut.setText("cos");
        cosBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cosButActionPerformed(evt);
            }
        });

        tanBut.setText("tan");
        tanBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lBrac, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBrac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCurl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rCurl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sinBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cosBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanBut))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Num7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Num9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(AddButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(MinusButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Num4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(Num6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(MultButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(DivideButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Num1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(Num3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(ExpButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(ClearButt, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LPan, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(RPant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(EqButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LPan, Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9, RPant});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddButt, ClearButt, DivideButt, ExpButt, MinusButt, MultButt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lBrac, lCurl, rBrac, rCurl});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(Num8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MinusButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MultButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(Num5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DivideButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ExpButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(Num2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Num3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LPan, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(Num0, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(RPant, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(EqButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lBrac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rBrac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lCurl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rCurl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sinBut)
                    .addComponent(cosBut)
                    .addComponent(tanBut))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LPan, Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9, RPant});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lBrac, lCurl, rBrac, rCurl});

        Result.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Num7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num7ActionPerformed
        // TODO add your handling code here:\
       Result.setText(Result.getText()+"7");
       
    }//GEN-LAST:event_Num7ActionPerformed

    private void ResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResultActionPerformed
    
    private void ClearButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtActionPerformed
        // TODO add your handling code here:
        Result.setText("");
        postNums.clear();
    }//GEN-LAST:event_ClearButtActionPerformed

    private void Num8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num8ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"8");
    }//GEN-LAST:event_Num8ActionPerformed

    private void Num9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num9ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"9");
    }//GEN-LAST:event_Num9ActionPerformed

    private void Num4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num4ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"4");
    }//GEN-LAST:event_Num4ActionPerformed

    private void Num5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num5ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"5");
    }//GEN-LAST:event_Num5ActionPerformed

    private void Num6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num6ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"6");
    }//GEN-LAST:event_Num6ActionPerformed

    private void Num1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num1ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"1");
    }//GEN-LAST:event_Num1ActionPerformed

    private void Num2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num2ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"2");
    }//GEN-LAST:event_Num2ActionPerformed

    private void Num3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num3ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"3");
    }//GEN-LAST:event_Num3ActionPerformed

    private void Num0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Num0ActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+"0");
    }//GEN-LAST:event_Num0ActionPerformed

    private void AddButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtActionPerformed
        // TODO add your handling code here:
       Result.setText(Result.getText()+ "+");
    }//GEN-LAST:event_AddButtActionPerformed

    private void MinusButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusButtActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "-");
    }//GEN-LAST:event_MinusButtActionPerformed

    private void MultButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultButtActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "*");
    }//GEN-LAST:event_MultButtActionPerformed

    private void DivideButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivideButtActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "/");
    }//GEN-LAST:event_DivideButtActionPerformed

    private void ExpButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpButtActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "^");
    }//GEN-LAST:event_ExpButtActionPerformed

    private void LPanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LPanActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "(");
    }//GEN-LAST:event_LPanActionPerformed

    private void RPantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RPantActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ ")");
    }//GEN-LAST:event_RPantActionPerformed

    private void EqButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqButtActionPerformed
        // TODO add your handling code here:
        try{
        System.out.println(Result.getText());
        parseAll(Result.getText());
        }catch (Exception e){
            Result.setText("Please input valid problem.");
            postNums.clear();
            //Result.setText("");
        }
    }//GEN-LAST:event_EqButtActionPerformed

    private void rCurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCurlActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "}");
    }//GEN-LAST:event_rCurlActionPerformed

    private void lBracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lBracActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "[");
    }//GEN-LAST:event_lBracActionPerformed

    private void rBracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBracActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "]");
    }//GEN-LAST:event_rBracActionPerformed

    private void lCurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lCurlActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "{");
    }//GEN-LAST:event_lCurlActionPerformed

    private void sinButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinButActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "s");
    }//GEN-LAST:event_sinButActionPerformed

    private void cosButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosButActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "c");
    }//GEN-LAST:event_cosButActionPerformed

    private void tanButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanButActionPerformed
        // TODO add your handling code here:
        Result.setText(Result.getText()+ "t");
    }//GEN-LAST:event_tanButActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcFrame().setVisible(true);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButt;
    private javax.swing.JButton ClearButt;
    private javax.swing.JButton DivideButt;
    private javax.swing.JButton EqButt;
    private javax.swing.JButton ExpButt;
    private javax.swing.JButton LPan;
    private javax.swing.JButton MinusButt;
    private javax.swing.JButton MultButt;
    private javax.swing.JButton Num0;
    private javax.swing.JButton Num1;
    private javax.swing.JButton Num2;
    private javax.swing.JButton Num3;
    private javax.swing.JButton Num4;
    private javax.swing.JButton Num5;
    private javax.swing.JButton Num6;
    private javax.swing.JButton Num7;
    private javax.swing.JButton Num8;
    private javax.swing.JButton Num9;
    private javax.swing.JButton RPant;
    private javax.swing.JTextField Result;
    private javax.swing.JButton cosBut;
    private javax.swing.JButton lBrac;
    private javax.swing.JButton lCurl;
    private javax.swing.JButton rBrac;
    private javax.swing.JButton rCurl;
    private javax.swing.JButton sinBut;
    private javax.swing.JButton tanBut;
    // End of variables declaration//GEN-END:variables

}
