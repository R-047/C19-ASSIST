package backend;

public class del{
	public del(int pid){
		 linkedList.node prevnode = linkedList.patientListHead;
		 linkedList.node pointer = linkedList.patientListHead;
		 while(pointer != null){
		 	if(pid == linkedList.patientListHead.PID){
		 		linkedList.patientListHead = linkedList.patientListHead.link;
		 		break;
		 		}
		 	
		 	if(pid == pointer.PID){
				 if(pointer == linkedList.patientListCurrNode){
					linkedList.patientListCurrNode = prevnode;
				 }
		 		prevnode.link = pointer.link;
		 		pointer.link = null;
		 		break;
		 		}
		  	prevnode = pointer;
		 	pointer = pointer.link;
		 	}

			}
	}