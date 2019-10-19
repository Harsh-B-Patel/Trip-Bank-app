package com.example.tripbankapp;

/**
 * Created by mailh on 2018-03-15.
 */

public class Bank {
    Client[] client = new Client[6];
    int noc = 0;
    String service = null;

    String name;
    boolean p1 = true;
    int t1 = -1;
    int t2 = -1;
    int a2 = 0;
    boolean e1 = false;
    boolean e2 = false;
    boolean exist = false;
    String n1 = null;
    String n2 = null;
    String ename = null;
    boolean can = true;
    boolean can1 = true;

    Bank() {

    }

/*
bank is used to call methods in controller to get data in to client array of Client class, (add methods for calculations in clinet class
if statemmatd in bank to get correect thing .NEXT add getters for that in bank which will publish that in controller.
 */

    void addClinet(String Name, double amt) {
        if (noc < 6) {
            for (int a = 0; a < noc; a++) {
                if (client[a].getname().equals(Name)) {
                    exist = true;
                    ename = Name;
                }
            }
            if (amt >= 0 && !exist) {
                if (!exist) {
                    client[noc] = new Client(Name, amt);
                    noc++;
                }
            }
            else if (amt < 0 && !exist) {
                p1= false;
            }
        }
    }


    int getNoc() {
        return noc;
    }

    void setService(String s) {
        this.service = s;
    }


    void Transaction(String fromclinet, String toclient, double amt, String service) {
        n1 = toclient;
        n2 = fromclinet;

        if (service.equals("DEPOSIT")) {
            setName(toclient);
            //n1 = toclient;
            for (int a = 0; a < noc; a++) {
                if (client[a].getname().equals(toclient)) {
                    t1 = a;
                    e1 = true;
                }

            }
            if (e1) {
                if (amt > 0) {
                    if (t1 != -1) {
                        client[t1].setdeposit(amt);

                    }
                } else if (amt < 0) {
                    a2++;
                }
            }
            t2 = 0;
        } else if (service.equals("WITHDRAW")) {
            setName(fromclinet);
            //n2 = fromclinet;
            for (int a = 0; a < noc; a++) {
                if (client[a].getname().equals(fromclinet)) {
                    t2 = a;
                    e2 = true;
                }
            }


            if (e2) {
                if (amt >= 0) {
                    if (t2 != -1) {
                        if (client[t2].getAmount() <= amt) {
                            can = false;
                        }
                        if (can) {
                            client[t2].setWithdraw(amt);
                        }
                    }
                } else if (amt < 0) {
                    a2++;
                }
            }
            t1 = 0;
        } else if (service.equals("TRANSFER")) {
          //  n1 = fromclinet;
            for (int a = 0; a < noc; a++) {
                if (client[a].getname().equals(fromclinet)) {
                    t2 = a;
                    e1 = true;
                }
            }
           // n2 = toclient;
            for (int a = 0; a < noc; a++) {
                if (client[a].getname().equals(toclient)) {
                    t1 = a;
                    e2 = true;
                }
            }


            if (e1) {
                if (e2) {
                    if (amt >= 0) {
                        if (client[t2].getAmount() <= amt) {
                            can1 = false;
                        }
                        if (can1) {
                            client[t1].setdeposit(amt);
                            client[t2].setWithdraw(amt);
                        }
                    } else if (amt < 0) {
                        a2++;
                    }


                }
            }
        }
    }

    void setName(String ne) {
        this.name = ne;
    }

    String getName() {
        return name;
    }

    String toStringTranscation() {
        String s = null;

        if (t2 == -1) {
            s = "Client " + n2 + " Does Not Exist";
            t2 = -1;
        } else if (t1 == -1) {
            s = "Client " + n1 + " Does Not Exist";
            t1 = -1;
        } else if (a2 == 1) {
            s = "ERROR ENTER POSITIVE NUMBER";
            a2 = 0;
        }else if(!can){
            s = " Error: Amount too large to withdraw.";
            can = true;
        }else if(!can1) {
            s = " Error: Amount too large to transfer.";
            can1= true;
        }else if (t1 >= 0 && t2 >= 0) {
            s = "Updated Balances of Client" + "\n";
            for (int a = 0; a < noc; a++) {
                s += client[a].getname() + ". " + client[a].getAmount() + " \n";

            }

        }
        return s;
    }


    String CreateAccountTostring() {
        String s = null;
        if (noc < 6) {
            if (!exist) {
                if (!p1) {
                    s = "ERRROR : enter positive amount";
                    this.p1 = true;
                } else if (p1) {
                    s = "Updated Balances of Client" + "\n";
                    for (int a = 0; a < noc; a++) {
                        s += client[a].getname() + ". " + client[a].getAmount() + " \n";

                    }
                }
            } else {
                s = " CLIENT " + ename + " ALREADY EXIST";
                exist = false;
            }
        } else {
            s = "Error: Maximum Number of Clients Reached";

        }

        return s;
    }



    String statement(String name) {
        String b = "Client " + name + " Does Not Exist So No Statement";
        for (int a = 0; a < noc; a++) {
            if (client[a].getname().equals(name)) {
                b = client[a].getoutput();

            }
        }
        return b;
    }
}
