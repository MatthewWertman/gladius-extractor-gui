[CmdletBinding(DefaultParameterSetName="mvJar")]
Param (
    [String]$gladiusTools
)

(Get-Content -Path .\pom.xml -TotalCount 6)[-1] -match '[0-9]\.[0-9]+'
$path = 'target/Gladius-extractor-tool-' + $Matches[0] + '.jar'
Copy-Item $path $gladiusTools -Force