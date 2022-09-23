<html> 
<head> 
<link rel="stylesheet" type="text/css" href="test.css"/>

<script>
    function dateLocal(){
        let date = new Date();
        document.write(date.getHours() +":"+ date.getMinutes() +":"+ date.getSeconds());
    }
</script>

</head> 
<body> 
    <div>
        <h1>Bienvenue !</h1> 
        <p id="pHeure">
            Il est actuellement <?php $heure = date('H:i'); echo $heure; ?> sur le serveur
            et <script>dateLocal()</script> sur le navigateur
            et tout va très bien.
            Et nous somme le <?php $date = date('j/m/Y'); echo $date?>.
        </p> 
        
        <p>C’est <?php 
            $jour = date('j'); 
            if ($jour < 15) 
                echo 'le début'; 
            else 
                echo 'la fin' ?> du mois.</p>

        <!-- <img src="../Images/phpLogo.png"> -->
        <img src="/Images/phpLogo.png">

        <p class="loremIpsum">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas eros erat, elementum quis risus non, convallis dapibus velit. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque tristique tempus accumsan. Morbi nisl eros, luctus in ipsum non, aliquam placerat elit. Donec nec nisl in metus vehicula pellentesque eu vitae urna. Maecenas imperdiet luctus felis, a suscipit enim ultrices et. Etiam tincidunt porta dignissim.
        </p>
        <p class="loremIpsum">
        Sed ut orci ornare, hendrerit sem scelerisque, tincidunt sem. Mauris eget enim ex. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla aliquam eget neque a fringilla. Integer dignissim pulvinar orci, consectetur ultrices erat tristique vel. Duis volutpat nisl eros, venenatis efficitur dolor lacinia non. Aliquam erat volutpat. Duis vestibulum congue massa, sed ullamcorper ligula tincidunt ac. Curabitur volutpat consequat est, in dignissim nisl. Morbi pharetra massa id rhoncus rutrum. Nulla mollis neque non iaculis ornare. Vestibulum dignissim congue nunc non commodo. Donec ut augue tempus, posuere ligula vitae, mattis enim. Vestibulum ullamcorper fermentum neque eu rhoncus. Cras aliquam, lacus nec sagittis pellentesque, sapien nulla posuere lorem, sed rutrum elit ipsum pulvinar ex. Ut fringilla mattis nunc sed facilisis.
        </p>
        <p class="loremIpsum">
        Nullam sed lorem eget urna tristique suscipit. Maecenas egestas sollicitudin viverra. Morbi dictum massa quis neque pharetra dapibus eleifend iaculis nibh. Nullam placerat libero neque. Suspendisse ut sagittis metus. Nam lacinia nisl at nibh malesuada condimentum. Sed sit amet posuere sapien. Proin et suscipit urna, vitae laoreet velit. Nulla non dapibus enim. Praesent non leo nisi. Nunc mattis, massa et rutrum aliquam, dolor risus maximus magna, eu tempus est lorem et neque.
        </p> 
        <p class="loremIpsum">
        Pellentesque tristique ex sit amet bibendum lobortis. Nullam lobortis nibh neque, id tristique mi posuere non. Integer non ante sed lorem suscipit gravida a tincidunt dui. Curabitur ac eleifend ex. Nam vehicula nibh et est auctor, suscipit interdum nisl porta. Ut non euismod arcu, nec tempor mauris. Nulla sapien nunc, dictum sit amet malesuada in, tincidunt vel risus. Mauris condimentum aliquet quam, id pulvinar magna dictum non. Donec vulputate vitae sapien eu mollis. Vestibulum ut molestie purus, in bibendum orci. Vestibulum porttitor rhoncus libero, a egestas tellus luctus ut. Quisque quis tempus lorem, non venenatis ligula. Cras gravida fermentum rutrum. Pellentesque venenatis efficitur nisi vel iaculis. Pellentesque varius scelerisque nulla ultrices lacinia.
        </p> 
        <p class="loremIpsum">
        In nec ex quam. Integer volutpat consectetur enim nec pretium. Quisque sollicitudin nisi odio, quis ultrices arcu placerat sit amet. Duis eget ligula viverra, faucibus neque eget, volutpat lorem. Sed sit amet risus ut mi vestibulum tempus. Nullam feugiat aliquet neque, vel bibendum nulla eleifend nec. Mauris hendrerit faucibus nisi, vel malesuada arcu mattis et. Donec hendrerit scelerisque massa, at tempor massa maximus ac. Donec rhoncus metus ante, at interdum dui porttitor rhoncus. Duis eget nunc odio. Nam erat dolor, congue at tellus ut, tincidunt condimentum enim. Suspendisse tristique vestibulum arcu ut fermentum.
        </p>
    </div>
</body> 
</html>