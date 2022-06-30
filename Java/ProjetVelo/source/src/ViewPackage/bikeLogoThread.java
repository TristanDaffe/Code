package ViewPackage;

public class bikeLogoThread extends Thread {
    private BikeLogo bikeLogo;
    private int bikeStartFrame;
    private int bikeMaxFrame;

    public bikeLogoThread(BikeLogo bikeLogo){
        this.bikeLogo = bikeLogo;
        bikeStartFrame = 1;
        bikeMaxFrame = 78;
    }

    public void run() {
        while(true){
            for(int frame = bikeStartFrame; frame <= bikeMaxFrame; frame++) {
                bikeLogo.changeFrame(frame);
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try{
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
